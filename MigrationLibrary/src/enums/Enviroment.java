package enums;

public enum Enviroment {
    CONNECTION("jdbc:mysql://localhost:3306/ticketing?allowPublicKeyRetrieval=true&useSSL=false"),
    DATABASE_NAME("ticketing"),
    USER("ticketing"),
    PASSWORD("secret"),
    REPOSITORY_PACKAGE("com.ticketsystem.init.domain.repositories"),
    ENTITY_PACKAGE("com.ticketsystem.init.infrastructure.entities"),
    ENTITY_ROUTE("C:\\Users\\jafet\\Desktop\\Proyectos Java\\learning\\MigrationLibrary\\src\\source\\entities"),
    REPOSITORY_ROUTE("C:\\Users\\jafet\\Desktop\\Proyectos Java\\learning\\MigrationLibrary\\src\\source\\repositories"),
    ENTITY_TEMPLATE("C:\\Users\\jafet\\Desktop\\Proyectos Java\\learning\\MigrationLibrary\\src\\filecreator\\entitybase.txt"),
    REPOSITORY_TEMPLATE("C:\\Users\\jafet\\Desktop\\Proyectos Java\\learning\\MigrationLibrary\\src\\filecreator\\repositorybase.txt");


    private final String manager;

    Enviroment(String manager){
        this.manager = manager;
    }

    @Override
    public String toString(){
        return this.manager;
    }
}
