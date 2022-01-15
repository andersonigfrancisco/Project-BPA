/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BPA.serviceapi.Models;
import java.util.Date;
import java.util.UUID;
import javax.persistence.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 *
 * @author THL
 */
@Entity(name="movement")
public class Movement {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    
    @Column(nullable=false, length=50)
    public String codemovement;
    
    @OneToOne
    @JoinColumn(name = "accountcreditid")
    public Account accountcredit;
    
    @OneToOne
    @JoinColumn(name = "accountdebitid")
    public Account accountdebit;
    
    @Column(nullable=false, length=50)
    public String bankdebitdode;
   
    @Column(nullable=false, length=50)
    public String bankcreditcode;
    
    @Column(nullable=false, length=50)
    public float amountmovement;
    
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datamovement;
    
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datavalidate_movement;
    
    @Column(nullable=false, length=50)
    private String description;
    
    @Column(nullable=false, length=50)
    private String numbercheque;
    
    @Column(nullable=false, length=50)
    private String rubric;
    
    @Column(nullable=false, length=50)
    private int agentmovementid;
    
    
    @OneToOne
    @JoinColumn(name = "typemoventid")
    public Typemovement typemovement;
    
    @Basic(optional = false)
    @Column(insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdat;
    
    @Basic(optional = false)
    @Column(insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeMovement() {
        return codemovement;
    }

    public void setCodeMovement(String codeMovement) {
        this.codemovement = codeMovement;
    }

    public Account getAccountcredit() {
        return accountcredit;
    }

    public void setAccountcredit(Account accountcredit) {
        this.accountcredit = accountcredit;
    }

    public Account getAccountdebit() {
        return accountdebit;
    }

    public void setAccountdebit(Account accountdebit) {
        this.accountdebit = accountdebit;
    }

    public String getBankdebitdode() {
        return bankdebitdode;
    }

    public void setBankdebitdode(String bankdebitdode) {
        this.bankdebitdode = bankdebitdode;
    }

    public String getBankcreditcode() {
        return bankcreditcode;
    }

    public void setBankcreditcode(String bankcreditcode) {
        this.bankcreditcode = bankcreditcode;
    }

    public float getAmountmovement() {
        return amountmovement;
    }

    public void setAmountmovement(float amountmovement) {
        this.amountmovement = amountmovement;
    }

    public Date getDatamovement() {
        return datamovement;
    }

    public void setDatamovement(Date datamovement) {
        this.datamovement = datamovement;
    }

    public Date getDataValidate_movement() {
        return datavalidate_movement;
    }

    public void setDataValidate_movement(Date dataValidate_movement) {
        this.datavalidate_movement = dataValidate_movement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumberCheque() {
        return numbercheque;
    }

    public void setNumberCheque(String numberCheque) {
        this.numbercheque = numberCheque;
    }

    public String getRubric() {
        return rubric;
    }

    public void setRubric(String rubric) {
        this.rubric = rubric;
    }

    public int getAgentmovementId() {
        return agentmovementid;
    }

    public void setAgentmovementId(int agentmovementId) {
        this.agentmovementid = agentmovementId;
    }

    public Typemovement getTypemovement() {
        return typemovement;
    }

    public void setTypemovement(Typemovement typemovement) {
        this.typemovement = typemovement;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public Date getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(Date updatedat) {
        this.updatedat = updatedat;
    }
    
    
   
    
    
}
