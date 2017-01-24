package com.hxy.test;

import com.alibaba.fastjson.JSON;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.apache.commons.lang3.StringUtils;

import javax.xml.namespace.QName;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Test
{

    private static final String IO_CODE = "13487";//为配送企业编码的值
    private static final String TEST_URL = "http://112.74.190.148:8080/webservice/erpQywHospitalOrderService";//测试地址

    public static void main(String[] args) throws AxisFault, UnsupportedEncodingException
    {
        //        Provider[] providers=Security.getProviders();
        //        for(Provider provider:providers) System.out.println(provider.getName());

        //配送商下载未确认的订单
        String interfaceName = "getHospitalOrder";
        Map<String, String> dataObject = new HashMap<>();
        dataObject.put("orgId", "8888");
        dataObject.put("peiSongQiYeCode", "13487");
        dataObject.put("startDate", "2017-01-22 00:09:08");
        dataObject.put("endDate", "2017-01-22 23:09:08");
        String jsonData = JSON.toJSONString(dataObject);
        System.out.println(jsonData);
        System.out.println(getResult(jsonData, interfaceName));
    }

    private static String getResult(String data, String interfaceName) throws AxisFault, UnsupportedEncodingException
    {
        String sign = getMessageDigest(IO_CODE + data, "SHA-1");
        System.out.println(sign);

        RPCServiceClient client = new RPCServiceClient();
        Options options = client.getOptions();

        // specify URL for invoking
        EndpointReference targetEPR = new EndpointReference(TEST_URL);
        options.setTo(targetEPR);

        // specify parameter value for remote getGreeting method
        Object[] opAddEntryArgs = new Object[]{data, sign};
        // specify returned type for getGreeting method
        Class<?>[] classes = new Class[]{String.class};

        // specify method name for calling and WSDL namespace
        QName qname = new QName("http://service.sslwebservice.imall.iloosen.com/", interfaceName);

        String result = (String) client.invokeBlocking(qname, opAddEntryArgs, classes)[0];

        return result;
    }

    private static String getMessageDigest(String str, String encName) throws UnsupportedEncodingException
    {
        byte[] digest = null;
        if (StringUtils.isBlank(encName))
        {
            encName = "SHA-1";
        }
        try
        {
            MessageDigest md = MessageDigest.getInstance(encName);
            md.update(str.getBytes("UTF-8"));
            digest = md.digest();
        } catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return byteArrayToHex(digest);
    }

    private static String byteArrayToHex(byte[] byteArray)
    {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] resultCharArray = new char[byteArray.length * 2];
        int index = 0;

        for (byte b : byteArray)
        {
            resultCharArray[index++] = hexDigits[b >>> 4 & 0xf];
            resultCharArray[index++] = hexDigits[b & 0xf];
        }

        return new String(resultCharArray);
    }

    private static class DataObject
    {
        private static final String orgId = "8888";
        private static final String peiSongQiYeCode = "13487";
        private final String startDate;
        private final String endDate;

        DataObject(String startDate, String endDate)
        {
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public String getOrgId()
        {
            return orgId;
        }

        public String getPeiSongQiYeCode()
        {
            return peiSongQiYeCode;
        }

        public String getStartDate()
        {
            return startDate;
        }

        public String getEndDate()
        {
            return endDate;
        }
    }
}
