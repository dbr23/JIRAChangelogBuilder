package net.foxopen.jira.changelog;

import java.util.Comparator;
import java.io.Serializable;

/**
 * Represents a JIRA issue for display in the changelog.
 *
 * @author apigram
 * @version 1.03.00
 */
public class Change implements Serializable {

  private static final long serialVersionUID = 4315403361667148998L;
  private String issueKey;
  private String issueType;
  private String description;

  /**
   * Default constructor that accepts a name and changelog description for a
   * JIRA issue.
   *
   * @param issueKey Issue name.
   * @param description Issue changelog description.
   * @param issueType Issue type.
   */
  public Change(String issueKey, String description, String issueType) {
    this.issueKey = issueKey;
    this.description = description;
    this.issueType = issueType;
  }

  /**
   * Obtain the JIRA identifier of the issue
   *
   * @return JIRA issue identifier
   */
  final String getKey() {
    // this is package level visibility as this function is only used internally
    // for comparisons and templating, and as such should not be overridden.
    return issueKey;
  }

  /**
   * Obtain the type of issue (e.g. Bug, New Feature, etc.)
   *
   * @return The issue type.
   */
  final String getType() {
    return issueType;
  }

  /**
   * Obtain the changelog description for the issue
   *
   * @return Changelog description
   */
  final String getDescription() {
    // this is package level visibility as this function is only used internally
    // for templating, and as such should not be overridden.
    return description;
  }
}

/**
 * Simple comparison class for comparing issue identifiers. Because all issues
 * should have the same project, this will sort based on trailing number.
 *
 * @author apigram
 */
class ChangeComparator implements Comparator<Change> {

  /**
   * Compare the identifiers of two changes. Used when generating the changelog
   * to sort the changes by issue ID.
   *
   * @param c1 The first change.
   * @param c2 The second change.
   * @return 0 if the identifiers are identical, otherwise the value of c1.name
   * - c2.name
   */
  public int compare(Change c1, Change c2) {
    return c1.getKey().compareTo(c2.getKey());
  }
}
