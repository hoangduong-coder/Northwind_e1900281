package fi.vamk.e1900281.finalProject;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "fi.vamk.e1900281.finalProject.Strings")
@Table(name = "strings")
public class Strings {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"string_id\"", nullable = false)
  private Integer stringId;
  @Column(name = "\"string_data\"", nullable = true)
  private String stringData;
}