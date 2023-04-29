package com.vccl.vmfi_boot.domains;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;
import org.springframework.data.annotation.Id;

@Table(name = "bank_mst")
@Entity
public class Banks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bank_id;

    @Column(name = "bank_name")
    private String bank_name;

    @Column(name = "org_type")
    private int org_type;

    @Column(name = "mandate_id")
    private int mandate_id;

    @Column(name = "ac_length_min")
    private int ac_length_min;

    @Column(name = "ac_length_max")
    private int ac_length_max;

    @Column(name = "active_yn")
    private int active_yn;

    @Column(name = "entry_type")
    private int entry_type;

    @Column(name = "created_by")
    private int created_by;

    @Column(name = "creation_dt")
    private Date creation_dt;

    @Column(name = "updated_by")
    private int updated_by;

    @Column(name = "update_dt")
    private Date update_dt;
}
