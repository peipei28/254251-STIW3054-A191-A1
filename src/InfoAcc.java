public class InfoAcc {

    private String matric;
    private String Gname1;
    private String Glink;


    public InfoAcc(String matric,String Gname1,String Glink){
        this.matric=matric;
        this.Gname1=Gname1;
        this.Glink=Glink;
    }

    public void setMatric(String matric){
        this.matric=matric;
    }

    public String getMatric(){
        return matric;

    }

    public void setName(String Gname1){
        this.Gname1=Gname1;
    }

    public String getName(){
        return Gname1;

    }

    public void setLink(String Glink){
        this.Glink=Glink;
    }

    public String getLink(){
        return Glink;

    }
}
