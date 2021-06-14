package my.html2file.html2excel.utils.css.support;

import my.html2file.html2excel.utils.css.CssApplier;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shaun Chyxion <br>
 * chyxion@163.com <br>
 * Oct 24, 2014 2:29:17 PM
 * @version 0.0.1
 * @since 0.0.1
 */
public class AlignApplier implements CssApplier {

    /**
     * {@inheritDoc}
     */
    @Override
	public Map<String, String> parse(Map<String, String> style) {
        Map<String, String> mapRtn = new HashMap<String, String>();
        String align = style.get(TEXT_ALIGN);
        if (!ArrayUtils.contains(new String[]{LEFT, CENTER, RIGHT, JUSTIFY}, align)) {
            align = LEFT;
        }
        mapRtn.put(TEXT_ALIGN, align);
        align = style.get(VETICAL_ALIGN);
        if (!ArrayUtils.contains(new String[]{TOP, MIDDLE, BOTTOM}, align)) {
            align = MIDDLE;
        }
        mapRtn.put(VETICAL_ALIGN, align);
        return mapRtn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void apply(HSSFCell cell, HSSFCellStyle cellStyle,
                      Map<String, String> style) {
        // text align
        String align = style.get(TEXT_ALIGN);
        HorizontalAlignment sAlign = HorizontalAlignment.LEFT;
        if (RIGHT.equals(align)) {
            sAlign = HorizontalAlignment.RIGHT;
        } else if (CENTER.equals(align)) {
            sAlign = HorizontalAlignment.CENTER;
        } else if (JUSTIFY.equals(align)) {
            sAlign = HorizontalAlignment.JUSTIFY;
        }
        cellStyle.setAlignment(sAlign);
        // vertical align
        align = style.get(VETICAL_ALIGN);
        VerticalAlignment vAlign = VerticalAlignment.CENTER;
        if (TOP.equals(align)) {
            vAlign = VerticalAlignment.TOP;
        } else if (BOTTOM.equals(align)) {
            vAlign = VerticalAlignment.BOTTOM;
        } else if (JUSTIFY.equals(align)) {
            vAlign = VerticalAlignment.JUSTIFY;
        }
        cellStyle.setVerticalAlignment(vAlign);
    }
}
