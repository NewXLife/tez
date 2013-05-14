/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.tez.dag.api.records;

import java.util.List;

import org.apache.tez.common.counters.TezCounters;
import org.apache.tez.dag.records.TezTaskAttemptID;
import org.apache.tez.dag.records.TezTaskID;

public interface TaskReport {
  public abstract TezTaskID getTaskId();
  public abstract TaskState getTaskState();
  public abstract float getProgress();
  public abstract long getStartTime();
  public abstract long getFinishTime();
  public abstract TezCounters getCounters();
  
  public abstract List<TezTaskAttemptID> getRunningAttemptsList();
  public abstract TezTaskAttemptID getRunningAttempt(int index);
  public abstract int getRunningAttemptsCount();
  
  public abstract TezTaskAttemptID getSuccessfulAttempt();
  
  public abstract List<String> getDiagnosticsList();
  public abstract String getDiagnostics(int index);
  public abstract int getDiagnosticsCount();
  
  
  public abstract void setTaskId(TezTaskID taskId);
  public abstract void setTaskState(TaskState taskState);
  public abstract void setProgress(float progress);
  public abstract void setStartTime(long startTime);
  public abstract void setFinishTime(long finishTime);
  public abstract void setCounters(TezCounters counters);
  
  public abstract void addAllRunningAttempts(List<TezTaskAttemptID> taskAttempts);
  public abstract void addRunningAttempt(TezTaskAttemptID taskAttempt);
  public abstract void removeRunningAttempt(int index);
  public abstract void clearRunningAttempts();
  
  public abstract void setSuccessfulAttempt(TezTaskAttemptID taskAttempt);
  public abstract void addAllDiagnostics(List<String> diagnostics);
  public abstract void addDiagnostics(String diagnostics);
  public abstract void removeDiagnostics(int index);
  public abstract void clearDiagnostics();
}
