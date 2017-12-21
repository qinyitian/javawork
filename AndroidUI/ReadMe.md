First listview
=================
(still have some question about picture position --solving)
--------------------------
--show picture and text
use imageview to show pic and set their width and higth to 128px<br>
use textview to show the name <br>
these two makes item.xml <br>
through to invoke item.xml makes the listview's basics structs <br>
then in activemain,use SimpleAdapter to create listview's content <br>

![result picture1](https://github.com/qinyitian/javawork/raw/master/img/a21.JPG)<br>
Second AlertDialog
=================
--create layout dialog.xml by LinerLayout include two textview and editview and two button<br>
then user AlertDialog.Buider to set come selection to show the AlertDialog<br>

![result picture2](https://github.com/qinyitian/javawork/raw/master/img/a22.JPG)<br>

Three
=================
these are codes about create menu<br>
-----------------------------------
    public boolean onCreateOptionsMenu(Menu menu) {<br>
        SubMenu sub=menu.addSubMenu("字体大小");<br>
        sub.add(0,1,0,"小");<br>
        sub.add(0,2,0,"中");<br>
        sub.add(0,3,0,"大");<br>
        SubMenu sub1=menu.addSubMenu("颜色");<br>
        sub1.add(0,4,0,"红色");<br>
        sub1.add(0,5,0,"黑色");<br>

        menu.add(0,6,0,"toast提示");<br>

        return true;<br>
    }<br>
**<br>
these are codes about function to change size and color<br>
-----------------------------------
    public void UpdateTextviewFont(float x){<br>
        TextView tv =(TextView)findViewById(R.id.maintextview);<br>
        tv.setTextSize(x);<br>
    }<br>
    public void UpdateTextviewFont(int x){<br>
        TextView tv =(TextView)findViewById(R.id.maintextview);<br>
        if(x == 1) {<br>
            tv.setTextColor(Color.RED);<br>
        }<br>
        else<br>
            tv.setTextColor(Color.BLACK);<br>
    }<br>
use no layout.xml<br>

![result picture3](https://github.com/qinyitian/javawork/raw/master/img/a231.JPG)<br>
![result picture3](https://github.com/qinyitian/javawork/raw/master/img/a232.JPG)<br>
![result picture3](https://github.com/qinyitian/javawork/raw/master/img/a233.JPG)<br>
![result picture3](https://github.com/qinyitian/javawork/raw/master/img/a234.JPG)<br>
