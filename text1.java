import java.io.*;

//import static org.graalvm.compiler.debug.TTY.flush;

//import static org.graalvm.compiler.debug.TTY.flush;

//import static org.graalvm.compiler.debug.TTY.flush;

public class text1 {
    public static void main(String args[]){
        try{
            FileInputStream input = new FileInputStream("E:\\练习\\软件工程\\yq_in.txt");
            InputStreamReader reader = new InputStreamReader(input,"gb2312");
            BufferedReader bufferedReader = new BufferedReader(reader);


            FileOutputStream output = new FileOutputStream("E:\\练习\\软件工程\\yq_out.txt");
            OutputStreamWriter writer = new OutputStreamWriter(output,"gb2312");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            //对文件进行处理
            String content = "";
            String province_value="";
            String str = "区域";
            while((content = bufferedReader.readLine())!=null){
                String province = content.substring(0,3);
                String remaining = content.substring(4);
                if(!(province_value.equals(province))){
                    if(province_value !=""){
                        bufferedWriter.write("\r\n");
                    }
                    bufferedWriter.write(province+"\r\n");
                    province_value = province;
                }
                if (!content.contains(str)){
                    bufferedWriter.write(remaining+"\r\n");
                    bufferedWriter.flush();
                }
            }
            input.close();
            output.close();
            reader.close();
            writer.close();
            bufferedReader.close();
            bufferedWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
