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
 * Classe contendo informações de parecer técnico
 */
public class Parecer {
    ArrayList<Informações> lista = new ArrayList<Informações>();

    public Parecer(int osnum) throws JSONException {
        String result = Linux.curl(null, NetworkUtils.urlizeGet(NetworkUtils.DB_TABLE_PARECER,NetworkUtils.DB_COL_OS_NUMERO, osnum + ""));
        JSONArray js = new JSONArray(result);

        for (int XXX = 0; XXX < js.length(); XXX++) {
            JSONObject x = js.getJSONObject(XXX);
            Date data = new Date(
                    TimeUtils.getYearBySQL(x.getString(NetworkUtils.DB_COL_PARECER_DATA)),
                    TimeUtils.getMonthBySQL(x.getString(NetworkUtils.DB_COL_PARECER_DATA)),
                    TimeUtils.getDayBySQL(x.getString(NetworkUtils.DB_COL_PARECER_DATA)),
                    TimeUtils.getHoursBySQL(x.getString(NetworkUtils.DB_COL_PARECER_DATA)),
                    TimeUtils.getMinutesBySQL(x.getString(NetworkUtils.DB_COL_PARECER_DATA)),
                    TimeUtils.getSecondsBySQL(x.getString(NetworkUtils.DB_COL_PARECER_DATA))
            );

            lista.add(new Informações(
                    data,
                    x.getString(NetworkUtils.DB_COL_PARECER_COLABORADOR),
                    x.getString(NetworkUtils.DB_COL_PARECER_DESCRICAO)
            ));
        }

    }

    public Informações getInfo(int posição) {
        return lista.get(posição);
    }

    public static class Informações {
        private Date date;
        private String mechanique = "Zé Ninguém";
        private String description = "NÃO FIZ NADA NO SEU CARRO E NEM VOU FAZER!!";

        public Informações(Date date, String mechanique, String description) {
            this.date = date;
            this.mechanique = mechanique;
            this.description = description;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getMechanique() {
            return mechanique;
        }

        public void setMechanique(String mechanique) {
            this.mechanique = mechanique;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    //DONE
}
