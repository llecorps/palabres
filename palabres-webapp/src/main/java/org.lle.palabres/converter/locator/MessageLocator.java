package org.lle.palabres.converter.locator;


import com.opensymphony.xwork2.conversion.TypeConversionException;
import org.apache.struts2.util.StrutsTypeConverter;
import org.example.palabres.business.contract.ManagerFactory;
import org.example.palabres.model.exception.NotFoundException;
import org.springframework.util.StringUtils;

import javax.inject.Inject;
import java.util.Map;

public class MessageLocator extends StrutsTypeConverter {

    @Inject
    private ManagerFactory managerFactory;

    @Override
    public Object convertFromString(Map pContext, String[] pValues, Class pToClass) {
        Object vRetour = null;

        if (pValues != null) {
            if (pValues.length == 1) {
                String vValue = pValues[0];
                try {
                    vRetour
                            = StringUtils.isEmpty(vValue)
                            ? null
                            : managerFactory.getChatManager().getChannel(vValue);
                } catch (NumberFormatException pEx) {
                    throw new TypeConversionException("Format d'identifiant channel invalide", pEx);
                } catch (NotFoundException pEx) {
                    throw new TypeConversionException("Channel introuvable", pEx);
                }
            } else {
                vRetour = performFallbackConversion(pContext, pValues, pToClass);
            }
        }

        return vRetour;

    }

    @Override
    public String convertToString(Map map, Object o) {
        return null;
    }

}
