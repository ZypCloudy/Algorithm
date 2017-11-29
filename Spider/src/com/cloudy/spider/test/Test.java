package com.cloudy.spider.test;

import java.util.List;

import com.cloudy.spider.bean.LinkTypeData;
import com.cloudy.spider.core.ExtractService;
import com.cloudy.spider.rule.Rule;

public class Test
{
//	@org.junit.Test
//	public void getDatasByClass()
//	{
//		Rule rule = new Rule("https://www.toutiao.com/search",
//				new String[] { "keyword" },
//				new String[] { "Hello" },
//				"cont_right", Rule.CLASS, Rule.POST);
//		List<LinkTypeData> extracts = ExtractService.extract(rule);
//		printf(extracts);
//	}

	@org.junit.Test
	public void getDatasByCssQuery()
	{
		Rule rule = new Rule("https://www.toutiao.com/search",
				new String[] { "keyword" },
				new String[] { "Hello" },
				"div", Rule.SELECTION, Rule.GET);
		List<LinkTypeData> extracts = ExtractService.extract(rule);
		printf(extracts);
	}

	public void printf(List<LinkTypeData> datas)
	{
		for (LinkTypeData data : datas)
		{
			System.out.println(data.getLinkText());
			System.out.println(data.getLinkHref());
			System.out.println("***********************************");
		}

	}
}
