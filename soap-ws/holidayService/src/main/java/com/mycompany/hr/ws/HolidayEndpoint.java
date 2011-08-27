package com.mycompany.hr.ws;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.mycompany.hr.service.HumanResourceService;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.xpath.XPath;
import org.springframework.ws.server.endpoint.AbstractJDomPayloadEndpoint;

public class HolidayEndpoint extends AbstractJDomPayloadEndpoint {

    private XPath startDateExpression;

    private XPath endDateExpression;

    private XPath nameExpression;

    private final HumanResourceService humanResourceService;
    Namespace namespace = Namespace.getNamespace("hr", "http://mycompany.com/hr/schemas");

    public HolidayEndpoint(HumanResourceService humanResourceService) throws JDOMException {
        this.humanResourceService = humanResourceService;
        System.out.println("-----HolidayEndpoint------");
        startDateExpression = XPath.newInstance("//hr:StartDate");
        startDateExpression.addNamespace(namespace);
        endDateExpression = XPath.newInstance("//hr:EndDate");
        endDateExpression.addNamespace(namespace);
        nameExpression = XPath.newInstance("concat(//hr:FirstName,' ',//hr:LastName)");
        nameExpression.addNamespace(namespace);
    }

    protected Element invokeInternal(Element holidayRequest) throws Exception {  
    	System.out.println("----InvokeInternal------");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = dateFormat.parse(startDateExpression.valueOf(holidayRequest));
        Date endDate = dateFormat.parse(endDateExpression.valueOf(holidayRequest));
        String name = nameExpression.valueOf(holidayRequest);

        humanResourceService.bookHoliday(startDate, endDate, name);
        Element nodeElement = new Element("Result", namespace);
        nodeElement.addContent("hello world");
        return nodeElement;
    }
}
