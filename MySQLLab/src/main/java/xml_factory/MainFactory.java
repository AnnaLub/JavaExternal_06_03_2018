package xml_factory;

public class MainFactory {
    public static void main(String[] args) {
        //SAXBuilder
        /*TeachersSAXBuilder saxBuilder = new TeachersSAXBuilder();
        saxBuilder.buildSetTeachers("data/teachers.xml");
        System.out.println(saxBuilder.getTeachers());*/

        //DOMBuilder
      /*  TeachersDOMBuilder domBuilder = new TeachersDOMBuilder();
        domBuilder.buildSetTeachers("data/teachers.xml");
        System.out.println(domBuilder.getTeachers());*/

      //StAXBuilder
       /* TeachersStAXBuilder stAXBuilder = new TeachersStAXBuilder();
        stAXBuilder.buildSetTeachers("data/teachers.xml");
        System.out.println(stAXBuilder.getTeachers());*/

       TeachersBuilderFactory tFactory = new TeachersBuilderFactory();
       AbstractTeachersBuilder builder = tFactory.createTeacherBuilder("sax");
       builder.buildSetTeachers("data/teachers.xml");
       System.out.println(builder.getTeachers());


    }
}
