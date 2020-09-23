package br.com.senac.pif_mobile;

import org.jetbrains.annotations.Nullable;

import java.util.Date;


/**
 * GETTERS E SETTERS DA TABELA os
 */
public class OS {
    public enum SITUACAO {
        NA_FILA, //ESPERA NA FILA
        EM_ANALISE, //CHECAGEM DE REPARAÇÃO
        AGUARDANDO_PEÇAS, //ESPERANDO A CENTRAL DE PEÇAS ENtrEGAR
        EM_PROCESSO_DE_MANUTENCAO, //VEÍCULO SENDO CONSERTADO
        AGUARDANDO_DEVOLUÇÂO, //O CLIENTE DEVE BUSCAR
        CONCLUIDO, // MAIS NADA PRA FAZER

        //situação extra (em caso de falhas ou algo assim:
        BLOQUEADO //CARRO ESTÁ BLOQUEADO POR ALGUM MOTIVO EM ESPECÍFICO
    }
    private int num = 0;
    private String sign = "AAA0000";
    private SITUACAO situacao;
    private Date entry, prevision, out;
    private String collab = "Zé Ninguém";


    public OS(int num, String sign, SITUACAO situacao, Date entry, Date prevision, Date out, String collab) {
        this.num = num;
        this.sign = sign;
        this.situacao = situacao;
        this.entry = entry;
        this.prevision = prevision;
        this.out = out;
        this.collab = collab;
    }

    public OS(int num, String sign, SITUACAO situacao, Date entry, Date prevision, Date out) {
        this(num,sign,situacao,entry,prevision,out,"Zé Ninguém");
    }

    public int getNum() {
        return num;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public SITUACAO getSituacao() {
        return situacao;
    }

    public void setSituacao(SITUACAO situacao) {
        this.situacao = situacao;
    }

    public Date getEntry() {
        return entry;
    }

    public void setEntry(Date entry) {
        this.entry = entry;
    }

    public Date getPrevision() {
        return prevision;
    }

    public void setPrevision(Date prevision) {
        this.prevision = prevision;
    }

    public Date getOut() {
        return out;
    }

    public void setOut(Date out) {
        this.out = out;
    }

    public String getCollab() {
        return collab;
    }

    public void setCollab(String collab) {
        this.collab = collab;
    }

    public static SITUACAO getSituation(String jsonValue) {
        switch (jsonValue) {
            case "Na fila": return SITUACAO.NA_FILA; //aquele "NA_FILA" é pra ser o que ta no banco de dados e que vai vir no json, né? exato ok, só que no bd ta um bucado diferente
            case "Em análise": return SITUACAO.EM_ANALISE; //pq eu deixei como no combo box, pra ficar mais bonito visualmente
            case "Aguardando peças": return SITUACAO.AGUARDANDO_PEÇAS;
            case "Em processo de manutenção": return SITUACAO.EM_PROCESSO_DE_MANUTENCAO;
            case "Aguardando devolução": return SITUACAO.AGUARDANDO_DEVOLUÇÂO;
            case "Concluído!": return SITUACAO.CONCLUIDO;
            case "Bloqueado": return SITUACAO.BLOQUEADO;
            default: return  SITUACAO.NA_FILA;
        }
    }

    public static int situationPercentage() {
        return 100 / 5; //100% do progresso dividido por todas as situações exceto Na Fila (0%) e Bloqueado (INDETERMINADO)
    }

    public static int getSituationPercentage(SITUACAO sit) {
        switch (sit) {
            case BLOQUEADO: return -1; //INDETERMINADO
            case NA_FILA: return 0; //0%
            case EM_ANALISE: return situationPercentage() * 1; //primeiro estagio da barra de progresso (de 5)
            case AGUARDANDO_PEÇAS: return situationPercentage() * 2;
            case EM_PROCESSO_DE_MANUTENCAO: return situationPercentage() * 3;
            case AGUARDANDO_DEVOLUÇÂO: return situationPercentage() * 4;
            case CONCLUIDO: return situationPercentage() * 5; //100%
            default: return -1;
        }
    }
}
