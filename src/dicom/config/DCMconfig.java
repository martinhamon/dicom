/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dicom.config;

/**
 *
 * @author MH
 */
public class DCMconfig {
     private String LOCAL_AE="";
    private String REMOTE_AE="";
    private int LOCAL_PORT=0;
    private int REMOTE_PORT=0;
    private String REMOTE_HOST="";
    
    public String getREMOTE_HOST() {
        return REMOTE_HOST;
    }

    public void setREMOTE_HOST(String REMOTE_HOST) {
        this.REMOTE_HOST = REMOTE_HOST;
    }

    public String getLOCAL_AE() {
        return LOCAL_AE;
    }

    public void setLOCAL_AE(String LOCAL_AE) {
        this.LOCAL_AE = LOCAL_AE;
    }

    public String getREMOTE_AE() {
        return REMOTE_AE;
    }

    public void setREMOTE_AE(String REMOTE_AE) {
        this.REMOTE_AE = REMOTE_AE;
    }

    public int getLOCAL_PORT() {
        return LOCAL_PORT;
    }

    public void setLOCAL_PORT(int LOCAL_PORT) {
        this.LOCAL_PORT = LOCAL_PORT;
    }

    public int getREMOTE_PORT() {
        return REMOTE_PORT;
    }

    public void setREMOTE_PORT(int REMOTE_PORT) {
        this.REMOTE_PORT = REMOTE_PORT;
    }
}
