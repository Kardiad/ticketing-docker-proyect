package normalize;

import enums.Enviroment;
import filecreator.FileWrapper;

public class RepositoryGenerator extends Normalize{

    private String entity;

    public RepositoryGenerator(String entity){
        this.entity = localeString(entity);
    }

    public void generateRepository(String baseRepository){
        String repositoryClone = baseRepository;
        repositoryClone = repositoryClone.replaceAll("\\{\\{repositoryPackage}}", Enviroment.REPOSITORY_PACKAGE.toString());
        repositoryClone = repositoryClone.replaceAll("\\{\\{entityPackage}}", Enviroment.ENTITY_PACKAGE.toString());
        repositoryClone = repositoryClone.replaceAll("\\{\\{entity}}", entity);
        new FileWrapper(Enviroment.REPOSITORY_ROUTE.toString()+"\\"+entity+"RepositoryInterface.java").generateFile(repositoryClone);
    }

}
