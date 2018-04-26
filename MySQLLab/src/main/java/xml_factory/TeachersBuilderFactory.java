package xml_factory;

public class TeachersBuilderFactory {
    private enum TypeParser{
        SAX,STAX,DOM;
    }
    public AbstractTeachersBuilder createTeacherBuilder(String typeParser){
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch(type){
            case DOM:
                return new TeachersDOMBuilder();
            case SAX:
                return new TeachersSAXBuilder();
            case STAX:
                return new TeachersStAXBuilder();
            default:
                throw new EnumConstantNotPresentException(type.getDeclaringClass(),type.name());
        }
    }
}
