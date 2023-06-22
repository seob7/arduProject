#include <dht.h>
#include <SoftwareSerial.h>

dht DHT;

#define DHT11_PIN 4

float humid; 
float temp;

SoftwareSerial mySerial(2,3); //RX,TX

String ssid = "AndroidHotspot."; //WIFI SSID
String PASSWORD = "pokl03630."; //WIFI PASSWORD
String host = "54.180.25.22"; //SERVER IP

void connectWifi(){
  //WIFI 접속
  String join ="AT+CWJAP=\""+ssid+"\",\""+PASSWORD+"\"";
      
  Serial.println("Connect Wifi...");
  mySerial.println(join);
  delay(10000);
  if(mySerial.find("OK"))
  {
    Serial.print("WIFI connect\n");
  }else
  {
   Serial.println("WIFI connect timeout\n");
  }
  delay(1000);
  }
  
void httpclient(String char_input){
  delay(100);
  Serial.println("connect TCP...");
  mySerial.println("AT+CIPSTART=\"TCP\",\"54.180.25.22\",80"); //서버 접속
  delay(500);
  if(Serial.find("ERROR")) return;
  
  Serial.println("Send data...");
  String url=char_input;
  String cmd="GET /process.jsp?id=1&temp="+url+" HTTP/1.0\r\n\r\n"; //센서값 전송
  //String cmd="GET /process.jsp?id=1&temp="+url+"\r\n\r\n";
  mySerial.print("AT+CIPSEND=");
  mySerial.println(cmd.length()+4);
  Serial.print("AT+CIPSEND=");
  Serial.println(cmd.length()+4);
  // if(mySerial.find(">"))
  // {
  //   Serial.print(">");
  // }else
  // {
  //   mySerial.println("AT+CIPCLOSE");
  //   Serial.println("connect timeout");
  //   delay(1000);
  //   return;
  // }
  delay(500);
       
  mySerial.println(cmd);
  Serial.println(cmd);
  delay(100);
  if(Serial.find("ERROR")) return;
  mySerial.println("AT+CIPCLOSE");
  delay(100);
  }  


void setup() {

  Serial.begin(9600);
  mySerial.begin(9600);

  connectWifi();
  delay(500);
}

void loop() {
  DHT.read11(DHT11_PIN);
  
  humid = DHT.humidity;
  temp = DHT.temperature; 
  String str_output = String(temp)+"&humid="+String(humid);
  delay(1000);
  httpclient(str_output);
  delay(1000);
   
   //Serial.find("+IPD");
   while (mySerial.available())
   {
    char response = mySerial.read();
    Serial.write(response);
    if(response=='\r') Serial.print('\n');
    }
   Serial.println("\n==================================\n");
   delay(2000);
}