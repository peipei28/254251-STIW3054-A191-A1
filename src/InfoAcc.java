public class InfoAcc {

    private String Gmatric;
    private String Gname1;
    private String Glink;


    public InfoAcc(String Gmatric,String Gname1,String Glink){
        this.Gmatric=Gmatric;
        this.Gname1=Gname1;
        this.Glink=Glink;
    }

    public void setMatric(String Gmatric){
        this.Gmatric=Gmatric;
    }

    public String getMatric(){
        return Gmatric;

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
