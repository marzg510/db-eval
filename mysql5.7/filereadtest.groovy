new File("tests/insert_into_t1.sql").eachLine {line->
    if (!line.isEmpty()) {
        println "line: ${line}"
    }
}