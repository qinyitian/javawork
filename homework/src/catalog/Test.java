package catalog;
import java.io.File;

public class Test {
    static int dirs = 0;//����ı������ڴ��ͳ�Ƴ�����Ŀ¼�������ļ�����
    static int files = 0;
    static long dirLength = 0 ;//����ı������ڴ��ͳ�Ƴ�����Ŀ¼��С���ļ���С
    static long fileLength = 0;
    static String preStr = "";//���������������������νṹչ�ֲ㼶
    File f = null;
    Test(File f){
        this.f = f;
    }

    public void tree(File f, int level) {

        String preStr = "";
        this.preStr=preStr;

        for (int i = 0; i < level; i++) {

            //�ж�level�Ĳ㼶����ÿ��һ������һ�����
            preStr +="\t";
        }

        //�����ļ����飬�ô�Ż�ȡ�����ļ�Ŀ¼���ļ�
        File[] childs = f.listFiles();

        for (int i = 0; i < childs.length; i++) {

            //��for ѭ��һ����ȡ����
            //childs[i].isDirectory()�����ж�ȡȡ������file���ļ�����Ŀ¼��Ȼ��ִ����Ӧ�Ĳ���
            if (childs[i].isDirectory()) {

                dirs++;//��ȡһ��Ŀ¼���Լ�һ�Σ���¼����           

            }else {

                files++;//��ȡһ���ļ����Լ�һ�Σ���¼����
                fileLength=childs[i].length();//���ļ��Ĵ�С���ֽ�����
                dirLength += childs[i].length();//����ȡ����ÿ���ļ��Ĵ�С���ֽ���������������¼����Ŀ¼�ֽ���

            }

            if (!childs[i].isDirectory()) {
                //��ӡ���������ļ���Ŀ¼,������ļ�����ʾ�ļ��ֽ���

                System.out.println(preStr + childs[i].getName()+"    "+fileLength+"�ֽ�");    
            }else{

                System.out.println(preStr + childs[i].getName());
                System.out.println(preStr +"-------------------------");
            }

            if (childs[i].isDirectory()) {
                //�ж��Ƿ�ΪĿ¼������ǣ��ٴ�ִ��tree��������������Ŀ¼������ļ��ٴα�������
                tree(childs[i], level + 1);
            }
        }

    }

    public static void main(String[] args) {

        //����ָ��Ŀ¼
        File f = new File("d:\\BaiduYunDownload");

        Test t = new Test(f);

        //��ӡָ��Ŀ¼�������Ŀ¼
        System.out.println("Ŀ��Ŀ¼��"+f.getName());

        //��ʼ����Ŀ¼
        t.tree(f, 1);
        System.out.println("==============================");
        //��ӡĿ¼�������ֽ���
        System.out.println("���Ŀ¼�й�:"+dirs+"��Ŀ¼");
        //��ӡ�ļ��������ֽ���
        System.out.println("���Ŀ¼����:"+files+"���ļ�"+"  "+"��"+dirLength+"�ֽ�");
        //System.out.println("==============================");
    }




}