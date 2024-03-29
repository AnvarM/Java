/* 
Example of pattern Adapter
*/

public class Adapter {
    public static void main(String[] args) {

        ATable aTable = new ATable() {
            @Override
            public String getCurrentUserName() {
                return "Amigo";
            }

            @Override
            public String getTableName() {
                return "DashboardTable";
            }
        };

        BTable table = new TableAdapter(aTable);
        System.out.println(table.getHeaderText());
    }

    public static class TableAdapter implements BTable{
        private ATable aTable;

        public TableAdapter(ATable a){
            this.aTable = a;
        }

        public String getHeaderText(){
            String s = "[" + this.aTable.getCurrentUserName() + "] : " + this.aTable.getTableName();
            return s;
        }

    }

    public interface ATable {
        String getCurrentUserName();
        String getTableName();
    }

    public interface BTable {
        String getHeaderText();
    }
}