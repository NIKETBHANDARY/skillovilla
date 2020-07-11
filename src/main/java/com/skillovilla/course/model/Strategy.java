package com.skillovilla.course.model;

import javax.persistence.*;
import java.io.Serializable;

@NamedQueries({
        @NamedQuery(name = "GET_STRATEGY_BY_STRATEGY_ID",query = "SELECT STR FROM Strategy STR WHERE STR.strategyID = :strategyID"),
        @NamedQuery(name = "GET_DEFAULT_STRATEGY",query = "SELECT STR FROM Strategy STR WHERE STR.isDefault = true ")
})

@Entity
@Table(name = "Strategy")
public class Strategy implements Serializable {
    private static final long serialVersionUID = -5953300901483467002L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StrategyID")
    private int strategyID;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "IsDefault")
    private boolean isDefault;

    public int getStrategyID() {
        return strategyID;
    }

    public void setStrategyID(int strategyID) {
        this.strategyID = strategyID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }
}
