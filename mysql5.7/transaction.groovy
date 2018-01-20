import java.sql.*
import java.nio.file.*

class FileWatcher implements Runnable {
    @Override
    public void run() {
        Path dir = new File("/tmp").toPath();
        FileSystem fs = dir.getFileSystem();
        try {
            WatchService watcher = fs.newWatchService;
            dir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE)
            WatchKey key = watcher.take();
            while(key.isValid()) {
                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();
                    if ( kind == StandardWatchEventKinds.OVERFLOW ) continue;
                    Path name = (Path)event.context();
                }
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        }

    }
}

// 先程インストールしたMySQLのドライバを指定
Class.forName("com.mysql.jdbc.Driver");

// データベースに接続 (DB名,ID,パスワードを指定)
Connection conn = DriverManager.getConnection("jdbc:mysql://dbsvr/user01?useSSL=false&user=root&password=mysql");
conn.setAutoCommit(false);
// ステートメントを作成
Statement stmt = conn.createStatement();
    
// INSERT
new File("tests/insert_into_t1.sql").eachLine {line->
    if (!line.isEmpty()) {
        println "sql: ${line}"
        stmt.executeUpdate(line)
    }
}

// goファイルが作成されるまで待つ

// コミット
conn.commit();
    
// ステートメントをクローズ
stmt.close();
// 接続をクローズ
conn.close();