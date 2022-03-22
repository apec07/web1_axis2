package idv.cm.client;

import javax.xml.namespace.QName;

import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

public class RPCClient {

	public static void main(String[] args) throws Exception {
	//  使用RPC方式呼叫WebService        
        RPCServiceClient serviceClient = new RPCServiceClient();
        Options options = serviceClient.getOptions();
        
        //  指定呼叫WebService的URL
        EndpointReference targetEPR = new EndpointReference("http://localhost:8080/axis2/services/SimpleService");
        options.setTo(targetEPR);
    //  指定getGreeting方法的引數值
        Object[] opAddEntryArgs = new Object[] {"super man"};
        //  指定getGreeting方法返回值的資料型別的Class物件
        Class[] classes = new Class[] {String.class};
        //  指定要呼叫的getGreeting方法及WSDL檔案的名稱空間
        QName opAddEntry = new QName("http://localhost:8080/web1/", "helloService");
        //  呼叫getGreeting方法並輸出該方法的返回值
        System.out.println(serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, classes)[0]);
        
        //  下面是呼叫getPrice方法的程式碼，這些程式碼與呼叫getGreeting方法的程式碼類似
        classes = new Class[] {int.class};
        opAddEntry = new QName("http://localhost:8080/web1/", "helloService");
        System.out.println(serviceClient.invokeBlocking(opAddEntry, new Object[]{}, classes)[0]);
	}

}
