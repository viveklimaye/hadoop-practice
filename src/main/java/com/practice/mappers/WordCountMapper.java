package com.practice.mappers;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	private Text keyOut = new Text();
	private IntWritable valueOut = new IntWritable(1);

	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		StringTokenizer tokenizer = new StringTokenizer(value.toString());
		while (tokenizer.hasMoreTokens()) {
			keyOut.clear();
			keyOut.set(tokenizer.nextToken());
			context.write(keyOut, valueOut);
		}
	}
}