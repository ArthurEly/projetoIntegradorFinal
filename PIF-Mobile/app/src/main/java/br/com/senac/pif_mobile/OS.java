package br.com.senac.pif_mobile;

import org.jetbrains.annotations.Nullable;

import java.util.Date;


/**
 * Terminei, pode ir lá fazer. até mais!! Acho que vou fazer amannha, nao deve demorar muito, pode continuar usando o pc
 * eu vou dormir, mó sono e amanha vou acordar cedo
 * dai tenta desligar o pc, acho que dá kkkkkkk
 * enooois até amanha
 *
 * quer dizer
 * se quiser usar o pc tbm ksadj
 * lfsa
 *
 * cara, quando tu acordar, vai aperecer na tua tela "NO OPERATING SYSTEM"
 * vai nada, nao é nem loco jjkkkkkk
 * to confiando em ti em seu filha d aputa ksksksk
 * bah, lembrei agora
 * dai tu n vai ter como testar pq eu deixo o celular do meu lado, na cama
 * mas só se tu quiser usar o pc pra fazer alguma coisa a mais, mas testar nao vai dar kkkkkk
 * vai demorar pra testar agr, ah entao tranquilo
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
            case "NULL": return SITUACAO.NA_FILA;
            case "EM_ANALISE": return SITUACAO.EM_ANALISE;
            case "AGUARDANDO_PEÇAS": return SITUACAO.AGUARDANDO_PEÇAS;
            case "EM_PROCESSO_DE_MANUTENCAO": return SITUACAO.EM_PROCESSO_DE_MANUTENCAO;
            case "AGUARDANDO_DEVOLUÇÂO": return SITUACAO.AGUARDANDO_DEVOLUÇÂO;
            case "CONCLUIDO": return SITUACAO.CONCLUIDO;
            default: return  SITUACAO.NA_FILA;
        }
    }
}
