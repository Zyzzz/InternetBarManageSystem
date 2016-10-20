package com.imudges.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

/**
 * Created by Administrator on 2016/10/20.
 */
@Entity
@Table(name = "user", schema = "ecommerce", catalog = "")
public class UserEntity {
    private Collection<IndentEntity> indentByUserid;

    @OneToMany(mappedBy = "userByUserId")
    public Collection<IndentEntity> getIndentByUserid() {
        return indentByUserid;
    }

    public void setIndentByUserid(Collection<IndentEntity> indentByUserid) {
        this.indentByUserid = indentByUserid;
    }
}
