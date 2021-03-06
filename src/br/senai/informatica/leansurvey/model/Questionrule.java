package br.senai.informatica.leansurvey.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Questionrule generated by hbm2java
 */
@Entity
@Table(name = "questionrule", catalog = "leansurvey")
public class Questionrule implements java.io.Serializable {

	private Long id;
	private Condition condition;
	private Questionrulegroup questionrulegroup;
	private int expectedValue;

	public Questionrule() {
	}

	public Questionrule(Condition condition, Questionrulegroup questionrulegroup, int expectedValue) {
		this.condition = condition;
		this.questionrulegroup = questionrulegroup;
		this.expectedValue = expectedValue;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "Id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ConditionId", nullable = false)
	public Condition getCondition() {
		return this.condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "QuestionRuleGroupId", nullable = false)
	public Questionrulegroup getQuestionrulegroup() {
		return this.questionrulegroup;
	}

	public void setQuestionrulegroup(Questionrulegroup questionrulegroup) {
		this.questionrulegroup = questionrulegroup;
	}

	@Column(name = "ExpectedValue", nullable = false)
	public int getExpectedValue() {
		return this.expectedValue;
	}

	public void setExpectedValue(int expectedValue) {
		this.expectedValue = expectedValue;
	}

}
