package sweepmine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Record {

    BufferedWriter bf;
    BufferedReader br;
    FileWriter out;
    FileReader in;

    public Record() {

    }

    // 写入局数
    public void writeNumber(int level, int i) {
        try {
            out = new FileWriter("record//number" + (level + 1) + ".txt", true);
            bf = new BufferedWriter(out);
            bf.write(i + "<>");
            bf.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 写入扫雷用时
    public void writeTime(int level, int i) {
        try {
            if (level == 0) {
                out = new FileWriter("record//firstLevel.txt", true);
                bf = new BufferedWriter(out);
                bf.write(i + "<>" + getTime() + "<>");
                bf.close();
                out.close();
            }
            if (level == 1) {
                out = new FileWriter("record//secondLevel.txt", true);
                bf = new BufferedWriter(out);
                bf.write(i + "<>" + getTime() + "<>");
                bf.close();
                out.close();
            }
            if (level == 2) {
                out = new FileWriter("record//thirdLevel.txt", true);
                bf = new BufferedWriter(out);
                bf.write(i + "<>" + getTime() + "<>");
                bf.close();
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 写入扫雷级别
    public void writeLevel(int i) {
        try {
            out = new FileWriter("record//level.txt");
            bf = new BufferedWriter(out);
            bf.write(i + "");
            bf.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 级别为用户自定义时写入方格数和雷数
    public void writeLevel4(int row, int column, int mine) {
        try {
            out = new FileWriter("record//level4.txt");
            bf = new BufferedWriter(out);
            bf.write(row + "<>" + column + "<>" + mine + "<>");
            bf.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 读取局数
    public String readNumber(int level) {
        String s = "";
        int c;
        try {
            in = new FileReader("record//number" + (level + 1) + ".txt");
            br = new BufferedReader(in);
            while ((c = br.read()) != -1) {
                s = s + (char) c;
            }
            br.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    // 读取扫雷用时
    public String readTime(int level) {
        String s = "";
        int c;
        try {
            if (level == 0) {
                in = new FileReader("record//firstLevel.txt");
                br = new BufferedReader(in);
                while ((c = br.read()) != -1) {
                    s = s + (char) c;
                }
                br.close();
                in.close();
            }
            if (level == 1) {
                in = new FileReader("record//secondLevel.txt");
                br = new BufferedReader(in);
                while ((c = br.read()) != -1) {
                    s = s + (char) c;
                }
                br.close();
                in.close();
            }
            if (level == 2) {
                in = new FileReader("record//thirdLevel.txt");
                br = new BufferedReader(in);
                while ((c = br.read()) != -1) {
                    s = s + (char) c;
                }
                br.close();
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    // 读取扫雷级别
    public String readLevel() {
        String s = "";
        int c;
        try {
            in = new FileReader("record/level.txt");
            br = new BufferedReader(in);
            while ((c = br.read()) != -1) {
                s = s + (char) c;
            }
            br.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    // 读取自定义方格数及雷数
    public String readLevel4() {
        String s = "";
        int c;
        try {
            in = new FileReader("record//level4.txt");
            br = new BufferedReader(in);
            while ((c = br.read()) != -1) {
                s = s + (char) c;
            }
            br.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    // 清空记录
    public void clear() {
        try {
            for (int i = 1; i < 4; i++) {
                out = new FileWriter("record//number" + i + ".txt");
                out.write("");
                out.close();
            }
            out = new FileWriter("record//firstLevel.txt");
            out.write("");
            out.close();
            out = new FileWriter("record//secondLevel.txt");
            out.write("");
            out.close();
            out = new FileWriter("record//thirdLevel.txt");
            out.write("");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 获取现在时间
    public String getTime() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 完整的时间
        String time = sdf.format(date);
        return time;
    }
}
