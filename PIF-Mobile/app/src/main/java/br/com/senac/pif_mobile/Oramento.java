package br.com.senac.pif_mobile;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

import br.com.senac.pif_mobile.util.Linux;
import br.com.senac.pif_mobile.util.NetworkUtils;
import br.com.senac.pif_mobile.util.TimeUtils;

/**
 * Classe contendo informações de orçamento (GETTER E SETTER COM CONEXÃO A NET)
 */
public class Oramento /*IH*/ {
    ArrayList<Informações> lista = new ArrayList<Informações>();

    public Oramento(int osnum) throws JSONException {
        String result = Linux.curl(null, NetworkUtils.urlizeGet(NetworkUtils.DB_TABLE_ORCAMENTO,NetworkUtils.DB_COL_OS_NUMERO, osnum + ""));
        JSONArray js = new JSONArray(result);

        for (int XXX = 0; XXX < js.length(); XXX++) {
            JSONObject x = js.getJSONObject(XXX);
            Date data = new Date(
                    TimeUtils.getYearBySQL(x.getString(NetworkUtils.DB_COL_ORCAMENTO_DATA)),
                    TimeUtils.getMonthBySQL(x.getString(NetworkUtils.DB_COL_ORCAMENTO_DATA)),
                    TimeUtils.getDayBySQL(x.getString(NetworkUtils.DB_COL_ORCAMENTO_DATA)),
                    TimeUtils.getHoursBySQL(x.getString(NetworkUtils.DB_COL_ORCAMENTO_DATA)),
                    TimeUtils.getMinutesBySQL(x.getString(NetworkUtils.DB_COL_ORCAMENTO_DATA)),
                    TimeUtils.getSecondsBySQL(x.getString(NetworkUtils.DB_COL_ORCAMENTO_DATA))
            );
            String price = "0";
            String price2 = "0";

            if (!x.getString(NetworkUtils.DB_COL_ORCAMENTO_PRECO_PECAS).equals("")) {
                price = x.getString(NetworkUtils.DB_COL_ORCAMENTO_PRECO_PECAS);
            }

            if (!x.getString(NetworkUtils.DB_COL_ORCAMENTO_PRECO_SERVICOS).equals("")) {
                price2 = x.getString(NetworkUtils.DB_COL_ORCAMENTO_PRECO_SERVICOS);
            }

            lista.add(new Informações(
                    Double.parseDouble(price), //criamos um if
                    x.getString(NetworkUtils.DB_COL_ORCAMENTO_DESCRICAO_PECAS),
                    Double.parseDouble(price2),
                    x.getString(NetworkUtils.DB_COL_ORCAMENTO_DESCRICAO_SERVICOS),
                    data
            ));
        }

    }

    public Informações getInfo(int posição) {
        return lista.get(posição);
    }

    public static class Informações {
        private double piece_price = 0.00;
        private double service_price = 0.00;
        private String piece_description = "Presentinho pra você!";
        private String service_description = "Presentinho pra você!";
        private Date date;

        public Informações(double piece_price, String piece_description, double service_price, String service_description, Date date) {
            this.setPiece_price(piece_price);
            this.setPiece_description(piece_description);
            this.setService_price(service_price);
            this.setService_description(service_description);
            this.date = date;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public double getPiece_price() {
            return piece_price;
        }

        public void setPiece_price(double piece_price) {
            this.piece_price = piece_price;
        }

        public double getService_price() {
            return service_price;
        }

        public void setService_price(double service_price) {
            this.service_price = service_price;
        }

        public String getPiece_description() {
            return piece_description;
        }

        public void setPiece_description(String piece_description) {
            this.piece_description = piece_description;
        }

        public String getService_description() {
            return service_description;
        }

        public void setService_description(String service_description) {
            this.service_description = service_description;
        }
    }

    //DONE
}
