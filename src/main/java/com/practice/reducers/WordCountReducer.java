package com.practice.reducers;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	private IntWritable valOut = new IntWritable();
	private int count;

	@Override
	public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		count = 0;
		for (IntWritable value : values)
			count += value.get();
		valOut.set(count);
		context.write(key, valOut);
	}

}
