/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pif.desktop.Classes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Blob;

/**
 *
 * @author arthu
 */
public class Equipamento {
    
    //declaração de variáveis
    private String equipTipo;
    private String equipModelo;
    private String equipMarca;
    private String equipNsOuImei;
    private String equipAcessorios;
    private Blob equipFoto;
    private String equipObservacoes;
    private String equipDefeitoCliente;
    private String equipIdParecerTecnico;
    private String equipSituacao;
    private String equipSolucao;
    //declaração de variáveis

    /**
     * @return the equipTipo
     */
    public String getEquipTipo() {
        return equipTipo;
    }

    /**
     * @param equipTipo the equipTipo to set
     */
    public void setEquipTipo(String equipTipo) {
        this.equipTipo = equipTipo;
    }

    /**
     * @return the equipModelo
     */
    public String getEquipModelo() {
        return equipModelo;
    }

    /**
     * @param equipModelo the equipModelo to set
     */
    public void setEquipModelo(String equipModelo) {
        this.equipModelo = equipModelo;
    }

    /**
     * @return the equipMarca
     */
    public String getEquipMarca() {
        return equipMarca;
    }

    /**
     * @param equipMarca the equipMarca to set
     */
    public void setEquipMarca(String equipMarca) {
        this.equipMarca = equipMarca;
    }

    /**
     * @return the equipNsOuImei
     */
    public String getEquipNsOuImei() {
        return equipNsOuImei;
    }

    /**
     * @param equipNsOuImei the equipNsOuImei to set
     */
    public void setEquipNsOuImei(String equipNsOuImei) {
        this.equipNsOuImei = equipNsOuImei;
    }

    /**
     * @return the equipAcessorios
     */
    public String getEquipAcessorios() {
        return equipAcessorios;
    }

    /**
     * @param equipAcessorios the equipAcessorios to set
     */
    public void setEquipAcessorios(String equipAcessorios) {
        this.equipAcessorios = equipAcessorios;
    }

    /**
     * @return the equipFoto
     */
    public Blob getEquipFoto() {
        return equipFoto;
    }

    /**
     * @param equipFoto the equipFoto to set
     */
    public void setEquipFoto(Blob equipFoto) {
        this.equipFoto = equipFoto;
    }

    /**
     * @return the equipObservacoes
     */
    public String getEquipObservacoes() {
        return equipObservacoes;
    }

    /**
     * @param equipObservacoes the equipObservacoes to set
     */
    public void setEquipObservacoes(String equipObservacoes) {
        this.equipObservacoes = equipObservacoes;
    }

    /**
     * @return the equipDefeitoCliente
     */
    public String getEquipDefeitoCliente() {
        return equipDefeitoCliente;
    }

    /**
     * @param equipDefeitoCliente the equipDefeitoCliente to set
     */
    public void setEquipDefeitoCliente(String equipDefeitoCliente) {
        this.equipDefeitoCliente = equipDefeitoCliente;
    }

    /**
     * @return the equipIdParecerTecnico
     */
    public String getEquipIdParecerTecnico() {
        return equipIdParecerTecnico;
    }

    /**
     * @param equipIdParecerTecnico the equipIdParecerTecnico to set
     */
    public void setEquipIdParecerTecnico(String equipIdParecerTecnico) {
        this.equipIdParecerTecnico = equipIdParecerTecnico;
    }

    /**
     * @return the equipSituacao
     */
    public String getEquipSituacao() {
        return equipSituacao;
    }

    /**
     * @param equipSituacao the equipSituacao to set
     */
    public void setEquipSituacao(String equipSituacao) {
        this.equipSituacao = equipSituacao;
    }

    /**
     * @return the equipSolucao
     */
    public String getEquipSolucao() {
        return equipSolucao;
    }

    /**
     * @param equipSolucao the equipSolucao to set
     */
    public void setEquipSolucao(String equipSolucao) {
        this.equipSolucao = equipSolucao;
    } 
}
