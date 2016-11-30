package com.cyxd.demo.j2ee.behavior.baseshow;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * <p>
 * <li>ClassFullName: com.cyxd.demo.j2ee.behavior.baseshow.ShowBean
 * <li>ClassName: ShowBean
 * <li>CreateDateTime: 2016年10月12日 下午6:16:44
 *
 * <p>
 * Description: ShowBean
 *
 * @author Slil
 * @version 1.0.0
 * @since 1.0.0
 *
 * @see
 * @see
 *
 */
public class ShowBean implements Serializable {

    /**
     * String title is show标题
     */
    private String title;

    /**
     * String label is show 标签
     */
    private String label;

    /**
     * String topicUri is show主图
     */
    private String topicUri;

    /**
     * String content is show具体内容，基本上都是富文本编辑之后的html内容
     */
    private String content;

    /**
     *  is no args constructors
     */
    public ShowBean() {

    }

    public String getTitle() {
	return title;
    }

    public String getLabel() {
	return label;
    }

    public String getTopicUri() {
	return topicUri;
    }

    public String getContent() {
	return content;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public void setLabel(String label) {
	this.label = label;
    }

    public void setTopicUri(String topicUri) {
	this.topicUri = topicUri;
    }

    public void setContent(String content) {
	this.content = content;
    }

    /**
     * 所有属性字段回显
     */
    @Override
    public String toString() {
	return ReflectionToStringBuilder.toString(this);
    }

}
