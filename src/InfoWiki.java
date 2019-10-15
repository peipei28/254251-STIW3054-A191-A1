public class InfoWiki {

    private String no;
    private String matric;
    private String name;


    public InfoWiki(String no,String matric,String name){
        this.no=no;
        this.matric=matric;
        this.name=name;
    }

    public void setNo(String no){
        this.no=no;
    }

    public String getNo(){
        return no;

    }

    public void setMatric(String matric){
        this.matric=matric;
    }

    public String getMatric(){
        return matric;

    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;

    }
}

