import java.sql.*
import java.nio.file.*
import java.util.concurrent.TimeUnit;

def t = new Thread(new Runnable() {
    @Override
    public void run() {
        Path dir = new File("/tmp").toPath();
        FileSystem fs = dir.getFileSystem();
        try {
            WatchService watcher = fs.newWatchService();
            def key = dir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE)
            while(key.isValid()) {
                def detectedKey = watcher.poll(30, TimeUnit.SECONDS);
                if ( detectedKey == null) throw RuntimeException("Watch Time Out")
                if ( detectedKey != key ) continue;
                for (WatchEvent<?> event : detectedKey.pollEvents()) {
                    if ( event.kind() == StandardWatchEventKinds.OVERFLOW ) continue;
                    Path name = (Path)event.context();
                    if ( name.toString().equals("go") ) {
                        println "detect file '${name}' created,end watch"
                        key.cancel();
                        break;
                    }
                    println "file created ${name}"
                    key.reset();
                }
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
);
t.start();
t.join();


/**
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
**/

