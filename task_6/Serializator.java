package task_6;

import java.io.*;

public class Serializator {
    public boolean serialization(Polygon polygon, String fileName){
        boolean flag = false;
        File f = new File(fileName);
        ObjectOutputStream outputStream = null;
        try{
            FileOutputStream fos = new FileOutputStream(f);
            if (fos!=null){
                outputStream = new ObjectOutputStream(fos);
                outputStream.writeObject(polygon);
                flag=true;
            }
        } catch (FileNotFoundException e) {
            System.err.println("File couldn't be created: " + e);
        } catch (IOException e) {
            System.err.println(e);
        }finally {
            try{
                if(outputStream!=null){
                    outputStream.close();
                }
            } catch (IOException e) {
                System.err.println("Error of stream close");
            }
        }
        return flag;
    }
    public Polygon deserialization(String fileName) throws InvalidObjectException{
        File file = new File(fileName);
        ObjectInputStream inputStream = null;
        try{
            FileInputStream fis = new FileInputStream(file);
            inputStream = new ObjectInputStream(fis);
            Polygon polygon = (Polygon)inputStream.readObject();
            return polygon;
        } catch (FileNotFoundException e) {
            System.err.println("Serialization file doesn't exist");
        } catch (IOException e) {
            System.err.println("I/O error");
        } catch (ClassNotFoundException e) {
            System.err.println("Class doesn't exist");
        }finally {
            try{
                if(inputStream!=null){
                    inputStream.close();
                }
            } catch (IOException e) {
                System.err.println("Error of stream close");
            }
        }
        throw new InvalidObjectException("object doesn't restored");
    }
}
