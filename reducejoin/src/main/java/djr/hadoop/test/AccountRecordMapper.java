package djr.hadoop.test;

import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

import org.apache.hadoop.io.Text;

public class AccountRecordMapper extends Mapper<Object, Text, Text, Text> {

	public void map(Object key, Text value, Context context) throws IOException, InterruptedException{
		String record = value.toString();
		String parts[] = record.split("\t");
		context.write(new Text(parts[0]), new Text("account\t" + parts[1]));
	}
}
