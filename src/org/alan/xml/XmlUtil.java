/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alan.xml;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import org.alan.model.Flow;
import org.alan.model.Item;

import org.alan.model.PacketInfo;
import org.alan.model.Protocol;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

/**
 *
 * @author alan
 */
public class XmlUtil {

    private Item getLists(Item subitemInfo, Element e) {
        if ("list".equals(TypeUtil.getType(e.getAttribute("type").getValue()))) {
            Item subitem = new Item();
            subitem.setCode(e.getAttribute("code").getValue());
            subitem.setType(TypeUtil.getType(e.getAttribute("type").getValue()));
            subitem.setText(e.getValue());
            subitemInfo.getItems().add(subitem);
        }
        return subitemInfo;
    }

    public static PacketInfo xmlElements(String xmlDoc) {
        PacketInfo packets = null;
        //创建一个新的字符串
        StringReader read = new StringReader(xmlDoc);
        //创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
        InputSource source = new InputSource(read);
        //创建一个新的SAXBuilder
        SAXBuilder sb = new SAXBuilder();
        try {
            //通过输入源构造一个Document
            Document doc = sb.build(source);
            //取的根元素
            Element root = doc.getRootElement();
            //System.out.println(root.getName());//输出根元素的名称（测试）
            //得到根元素所有子元素的集合
            List rootChilds = root.getChildren();
            //获得XML中的命名空间（XML中未定义可不写）
            //Namespace ns = root.getNamespace();
            Element et = null;
            Element pet = null;
            Element items = null;
            Element subitems = null;
            packets = new PacketInfo();
            for (int i = 0; i < rootChilds.size(); i++) {
                et = (Element) rootChilds.get(i);//循环依次得到子元素 Flow
                List protocolChilds = et.getChildren();
                Flow flow = new Flow();
                packets.getFlows().add(flow);
                for (int i_protocolChilds = 0; i_protocolChilds < protocolChilds.size(); i_protocolChilds++) {
                    pet = (Element) protocolChilds.get(i_protocolChilds);//循环依次得到protocol
                    Protocol pro = new Protocol();
                    pro.setCode(pet.getAttribute("code").getValue());
                    pro.setType(pet.getAttribute("type").getValue());
                    pro.setValue(pet.getAttribute("value").getValue());
                    flow.getProtocols().add(pro);
                    List itemChilds = pet.getChildren();
                    for (int i_item = 0; i_item < itemChilds.size(); i_item++) {
                        items = (Element) itemChilds.get(i_item);//循环依次得到protocol
                        Item itemInfo = new Item();
                        itemInfo.setCode(items.getAttribute("code").getValue());
                        itemInfo.setType(TypeUtil.getType(items.getAttribute("type").getValue()));
                        itemInfo.setReadFunc(TypeUtil.getFun(items.getAttribute("type").getValue()));
                        itemInfo.setText(items.getValue());
                        if ("list".equals(TypeUtil.getType(items.getAttribute("type").getValue()))) {
                            Item subitemInfo = new Item();
                            List subItemChilds = pet.getChildren();
                            for (int i_subItemChilds = 0; i_subItemChilds < subItemChilds.size(); i_subItemChilds++) {
                                subitems = (Element) subItemChilds.get(i_subItemChilds);//循环依次得到protocol
                                Item subitem = new Item();
                                subitem.setCode(subitems.getAttribute("code").getValue());
                                subitem.setType(TypeUtil.getType(subitems.getAttribute("type").getValue()));
                                subitem.setReadFunc(TypeUtil.getFun(subitems.getAttribute("type").getValue()));
                                subitem.setText(items.getValue());
                                subitemInfo.getItems().add(subitem);
                            }
                        } else {
                            pro.getItems().add(itemInfo);
                        }
                    }
                }
            }
        } catch (JDOMException e) {
            // TODO 自动生成 catch 块
            e.printStackTrace();
            packets = null;
        } catch (IOException e) {
            // TODO 自动生成 catch 块
            e.printStackTrace();
            packets = null;
        }
        return packets;
    }
}
