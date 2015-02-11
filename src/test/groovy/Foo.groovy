class FooSpec extends spock.lang.Specification {

    def "Trivial parameters can reference earlier ones."() {
        expect:
            foo == 'foo'
            bar == 'bar foo'
            boo == 'foo bar foo'

        where:
            foo = 'foo'
            bar = "bar ${foo}"
            boo = """foo ${bar}"""
    }

    def "Trivial parameters cannot reference later ones."() {
        expect:
            foo == 'foo'
            bar == 'bar foo'

        where:
            bar = "bar ${foo}" // MissingPropertyException: No such property: foo for class: FooSpec
            foo = 'foo'
    }

    def "Parameters given with << cannot reference earlier parameters."() {
        expect:
            foo == 'foo'
            bar == 'bar foo'

        where:
            foo = 'foo'
            bar << ["bar ${foo}"] // MissingPropertyException: No such property: foo for class: FooSpec
    }

    def "Parameters given with << and triple quotes cannot reference earlier parameters."() {
        expect:
            foo == 'foo'
            bar == 'bar foo'

        where:
            foo = 'foo'
            bar << ["""bar ${foo}"""] // MissingPropertyException: No such property: foo for class: FooSpec
    }

    def "Parameters given in table format cannot reference earlier parameters."() {
        expect:
            foo == 'foo'
            bar == 'bar'
            far == 'foo'

        where:
            foo = 'foo'
            bar   | far
            "bar" | "${foo}" // MissingPropertyException: No such property: foo for class: FooSpec
    }

}
