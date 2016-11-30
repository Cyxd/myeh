package com.cyxd.demo.java.lang;

import java.io.UnsupportedEncodingException;

public class StringTest {

    public static void main(String[] args) throws Exception {

	// String content =
	// "<p>如今，百姓手中的钱富裕了，各种投资活动开始提上日程。在投资了国内房产的同时，很多人将目光投向了海外房地产。在众多海外投资当中，美国是投资的重要选择之一。为什么海外投资很多人都选择美国？</p><p><br/></p><p>居世界首位的经济地位</p><p><br/></p><p>美国有高度发达的现代市场经济，其劳动生产率、国内生产总值和对外贸易额均居世界首位。虽然经历了次贷危机，但美国世界经济霸主的地位至今无人动摇。</p><p><br/></p><p>完整便捷的交通运输网</p><p><br/></p><p>美国拥有庞大、完整、便捷的交通运输网，运输工具和手段多种多样，有庞大的铁路网，公路网、航空网、内河航运网和管道运输网。美国铁路总长约22.5万千米，居世界第一位。2012年美国公路总长658.66万千米，居世界第一位，其中高速公路里程7.68万千米，居世界第二位。</p><p><br/></p><p>包容万千的文化</p><p><br/></p><p>美国是一个“大熔炉”，移民带来自己的文化，融入美国文化之中，最终形成一个统一的美国文化。，美国文化是在多民族共处的过程中，在吸收各民族优秀文化遗产的基础上，在北美大陆自然环境和社会条件影响下互相融合而成的独特的文化，美国文化具有兼容性、开放性和进取性的特点，是世界主流文化之一。</p><p><br/></p><p>拥有顶级大学的教育</p><p><br/></p><p>由于美国各州政府负责该州的教育，联邦政府可参与教育经费的预算，但不能直接管理。所以美国的教育类型较多，但这更促成了美国独具特色的教育。美国坐拥世界顶级大学，这一点就为投资美国拉了不少票，像以文科商科著称的哈佛大学、法科著称的耶鲁大学、约翰斯`霍普金斯大学、麻省理工大学等等。</p><p><br/></p><p>世界级的科技水平</p><p><br/></p><p>美国先进的科学技术著称世界，人类史上很多重要的发明，包括白炽灯、通用零件、生产线等都是源自美国。目前，美国在火箭技术、武器研究、材料科学、医学、生物工程、计算机等许多领域都处于世界领先地位。</p><p><br/></p>";
	//
	// String str = content.replaceAll("(<(.[^>]*)>)", "...");
	// System.out.println(str);
	// String str2 = str.replaceAll("(\\.{3,})", "...");
	// System.out.println(str2);
	//
	// String content2 = "按时发达时Qt EntryId,.";
	// System.out.println(content2.replaceAll("([a-zA-Z,.; ]|\\s)", ""));

	 String str3 = "\u53CB\u76DF\u63A8\u9001";
	 System.out.println(new String(str3.getBytes("utf-8")));

	String s1 = "abc";
	String s12 = "abc";
	String s2 = new String(s1);
	String s21 = new String(s1);
	String s3 = s1;
	System.out.println(s1 == s12);
	System.out.println(s1 == s2);
	System.out.println(s2 == s21);
	System.out.println(s3 == s2);
	System.out.println(s1 == s3);

	System.out.println((s1 + s2) == (s3 + s2));

    }

}
