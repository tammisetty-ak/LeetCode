class SQL {

    private class Table {
        int autoId;
        Map<Integer, List<String>> rows;
        int colSize;

        public Table(int columnSize) {
            colSize = columnSize;
            autoId = 0;
            rows = new HashMap<>();
        }
    }

    Map<String, Table> tables;

    public SQL(List<String> names, List<Integer> columns) {
        tables = new HashMap<>();

        for(int i = 0; i < names.size(); i++) {
            tables.put(names.get(i), new Table(columns.get(i)));
        }
    }
    
    public boolean ins(String name, List<String> row) {
        var table = tables.get(name);

        if(table == null || table.colSize != row.size()) {
            return false;
        }

        table.rows.put(++table.autoId, row);
        return true;
    }
    
    public void rmv(String name, int rowId) {
        var table = tables.get(name);
        if(table == null || table.colSize < rowId) {
            return;
        }

        table.rows.remove(rowId);
    }
    
    public String sel(String name, int rowId, int columnId) {
        var table = tables.get(name);

        if(table == null) {
            return "<null>";
        }

        List<String> strings = table.rows.get(rowId);

        if(strings == null || strings.size() < columnId) {
            return "<null>";
        }

        return strings.get(columnId - 1);
    }
    
    public List<String> exp(String name) {
        var table = tables.get(name);
        List<String> res = new ArrayList();
        
        if(table == null) {
            return res;
        }
        
        var entryset = table.rows.entrySet();

        for(var e: entryset) {
            res.add(e.getKey().toString() + "," + String.join(",", e.getValue()));
        }
        return res;

    }
}

/**
 * Your SQL object will be instantiated and called as such:
 * SQL obj = new SQL(names, columns);
 * boolean param_1 = obj.ins(name,row);
 * obj.rmv(name,rowId);
 * String param_3 = obj.sel(name,rowId,columnId);
 * List<String> param_4 = obj.exp(name);
 */