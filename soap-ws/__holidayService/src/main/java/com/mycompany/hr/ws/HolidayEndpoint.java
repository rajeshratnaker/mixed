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

    public HolidayEndpoint(HumanResourceService humanResourceService) throws JDOMException {
        this.humanResourceService = humanResourceService;
        Namespace namespace = Namespace.getNamespace("hr", "http://mycompany.com/hr/schemas");
        startDateExpression = XPath.newInstance("//hr:StartDate");
        startDateExpression.addNamespace(namespace);
        endDateExpression = XPath.newInstance("//hr:EndDate");
        endDateExpression.addNamespace(namespace);
        nameExpression = XPath.newInstance("concat(//hr:FirstName,' ',//hr:LastName)");
        nameExpression.addNamespace(namespace);
    }

    protected Element invokeInternal(Element holidayRequest) throws Exception {          
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = dateFormat.parse(startDateExpression.valueOf(holidayRequest));
        Date endDate = dateFormat.parse(endDateExpression.valueOf(holidayRequest));
        String name = nameExpression.valueOf(holidayRequest);

        humanResourceService.bookHoliday(startDate, endDate, name);
        return null;
    }
}