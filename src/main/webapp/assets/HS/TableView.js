HS.TableView = function (rootView) {
    this._rootView = rootView;
    
    var body = rootView.find('tbody');
    this._body = body;
    
    var onRemoveHandlers = [];
    this._onRemoveHandlers = onRemoveHandlers;
    
    this._body.on('click', '.button', function () {
        var button = $(this),
            row = button.closest('tr'),
            id = button.data('id');
        
        row.remove();
        
        onRemoveHandlers.forEach(function (fn) {
            fn(id);
        });
    });
};

HS.TableView.prototype.addRow = function () {
    var cells = Array.prototype.slice.call(arguments),
        id = cells.shift();
    
    cells = cells.map(function (html) {
        return '<td>' + html + '</td>';
    });
    
    this._body.append(
        '<tr>' +
        cells.join('') +
            '<td class="right aligned"><a data-id="' + id + '" class="ui red button"><i class="remove icon"></i></a></td>' +
        '</tr>'
    );
};

HS.TableView.prototype.clear = function () {
    this._body.empty();
};

HS.TableView.prototype.onRemove = function (fn) {
    this._onRemoveHandlers.push(fn);
};