package my.html2file.html2excel.utils.css.bean;

/**
 * 文件描述 自定义样式加成或覆盖
 *
 * @author petterobam
 * @Title: XlsCssStyle
 * @ProjectName html2file
 * @date 2019/9/1 10:17 AM
 */
public class XlsCssStyle {
    /**
     * 当为空表示作用所有行
     */
    private Integer row;
    /**
     * 当为空表示作用所有列
     */
    private Integer col;
    /**
     * css样式，多个用（;）分隔
     */
    private String style;
    /**
     * 是否覆盖作用，默认是
     */
    private boolean overEffect = true;

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public boolean isOverEffect() {
        return overEffect;
    }

    public void setOverEffect(boolean overEffect) {
        this.overEffect = overEffect;
    }
}
