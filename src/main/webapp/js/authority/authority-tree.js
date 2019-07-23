
//动态回显树
$('#authority-tree').tree({
    url:'/authority/queryAuthorityTree',
    onContextMenu: function(e, node){
        e.preventDefault();
        // select the node
        $('#authority-tree').tree('select', node.target);

        console.info(node);

        // display context menu
        $('#mm').menu('show', {
            left: e.pageX,
            top: e.pageY
        });
    }
})

