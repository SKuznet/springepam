package com.epam.learnspring.util.impl;

import com.epam.learnspring.util.CheckTextUtil;
import net.yandex.speller.services.spellservice.CheckTextRequest;
import net.yandex.speller.services.spellservice.SpellServiceSoap;
import org.springframework.stereotype.Component;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

@Component("checkTextUtil")
public class CheckTextUtilImpl implements CheckTextUtil {
    private final static String ADDRESS = "http://speller.yandex.net/services/spellservice?WSDL";

    @Override
    public String checkText(String text) {
        URL url = null;
        try {
            url = new URL(ADDRESS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        QName qName = new QName("http://speller.yandex.net/services/spellservice", "SpellService");
        Service service = Service.create(url, qName);
        SpellServiceSoap spellService = service.getPort(SpellServiceSoap.class);

        CheckTextRequest request = new CheckTextRequest();
        request.setLang("en");
        request.setFormat("plain");
        request.setText(text);

        if (spellService.checkText(request).getSpellResult().getError().size() != 0) {
            return spellService.checkText(request).getSpellResult().getError().get(0).getS().toString();
        } else {
            return "word correct!";
        }
    }

}
