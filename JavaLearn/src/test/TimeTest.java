package test;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TimeTest {

	@Test
	public void test() {
		// 通过LocalDateTime自带的parse来解析时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime localDateTime = LocalDateTime.parse("2020-09-27T13:54:36.469"); // 不指定解析格式时用默认的
        System.out.println(localDateTime);
        System.out.println(LocalDateTime.parse("2020-09-27 05:05:05", DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        System.out.println(LocalDateTime.parse("2020-09-27 05:05:05", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(LocalDateTime.parse("2020-09-27 11:05:05", DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
	}

}
