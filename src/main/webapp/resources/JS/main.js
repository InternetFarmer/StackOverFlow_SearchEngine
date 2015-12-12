function Answer(e, f, g, h, i, j, k, l, m, n) {
    this.answer_id = ko.observable(e);
    this.question_id = ko.observable(f);
    this.is_accepted = ko.observable(g);
    this.score = ko.observable(h);
    this.body = i;
    this.link = ko.observable(j);
    this.question = k;
    this.date = l;
    this.owner = m;
    this.editor = n;
}

function Question(e, f, g, h, i, j, k, l) {
    this.answer_count = ko.observable(e);
    this.body = f;
    this.is_answered = ko.observable(g);
    this.link = ko.observable(h);
    this.question_id = ko.observable(i);
    this.score = ko.observable(j);
    this.title = ko.observable(k);
    this.view_count = ko.observable(l);
}


var mappedAnswers = function (data) {
    return ko.utils.arrayMap(data, function (answer) {
        var q = new Question(answer.question.answer_count, answer.question.body, answer.question.is_answered,
                answer.question.link, answer.question.question_id, answer.question.score, answer.question.title,
                answer.question.view_count);
        return new Answer(answer.answer_id, answer.question_id, answer.is_accepted, answer.score, answer.body, answer.link, q,
                answer.creation_date, answer.owner, answer.last_editor);
    });
};

var encodeTag = function (tags) {
    var str = "";
    for (var i = 0; i < tags.length - 1; i++) {
        str += tags[i] + ";"
    }
    if (tags.length >= 1) {
        str += tags[tags.length - 1];
    }
    return str;
};

var MyModel = function () {
    var self = this;

    // All the products
    self.Answers = ko.observableArray("");

    self.SearchTerm = ko.observable("");

    self.Tags = ko.observableArray("");


    //send get request to the server and
    self.searchAnswer = function () {
        console.log(self.Tags());
        var tags = encodeTag(self.Tags());

        console.log(self.SearchTerm());
        if (self.SearchTerm() !== "") {
            $.getJSON("rest/answers/search?key=" + escape(self.SearchTerm()) + "&tags=" + tags, function (data) {
                console.log(data);
                self.Answers("");
                self.Answers(mappedAnswers(data));
            });
        }
        console.log(self.Answers());
    };
};